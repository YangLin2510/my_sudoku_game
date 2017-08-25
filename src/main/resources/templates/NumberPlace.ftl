<html>
<head>
    <title>数独</title>
    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/sudoku.css">
</head>
<body>
<div class="container-fluid logo">
    <div class="container">
        <h3>数独游戏</h3>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-10">
            <table class="sudoku-table">
                <#list data as list>
                   <tr>
                       <#list list as item>
                           <#if item == 0>
                               <td><input maxlength="1" pattern="[0-9]" class="user_input"></td>
                           </#if>
                           <#if item !=0>
                               <td><input readonly value="${item}" class="init_numbers"></td>
                           </#if>
                       </#list>
                   </tr>
                </#list>
            </table>
        </div>

        <div class="col-md-2 game-info-div">
            <div class="game-time">00:00</div>
            <div>
                <button class="btn btn-danger btn-block" onclick="reloadGame()">重新开始</button>
            </div>
            <div>
                <button class="btn btn-success btn-block" onclick="checkResult()">检查结果</button>
            </div>
        </div>
    </div>
</div>
</body>
<script src="webjars/jquery/2.1.3/jquery.min.js"></script>
<script>
    //计算加载页面到当前经过的分秒
    var second = 0;
    setInterval(function () {
        second += 1;
        m = parseInt(second / 60);
        s = second % 60;
        value = "";
        if (m == 0) {
            if (s < 10) {
                value = "00:" + "0" + s;
            }
            else {
                value = "00:" + s;
            }
        }
        else if (m < 10) {
            if (s < 10) {
                value = "0"+ m + ":" + "0" + s;
            }
            else {
                value = "0"+ m + ":" + s;
            }
        }
        else {
            if (s < 10) {
                value = m + ":" + "0" + s;
            }
            else {
                value = m + ":" + s;
            }
        }
        $(".game-time").html(value);
    }, 1000);

    /**
      重新加载
     **/
    function reloadGame() {
        window.location.reload(true);
    }

    /**
     * 检查数组是否是合法的数独
     */
    function checkResult() {
         var sArray = new Array();
         $(".sudoku-table").find("input").each(function () {
             sArray.push($(this).val());
         });
         var sudokuArray = new Array();
         for(var i=0;i<9;i++){
             var list = sArray.slice(i*9,i*9+9);
             sudokuArray.push(list);
         }
         for(var x=0;x<9;x++){
             for(var y=0;y<9;y++){
                 if(!checkPositionValid(x,y,sudokuArray)){
                     alert("第"+parseInt(x+1)+"行"+parseInt(y+1)+"列的数字不合法");
                     return;
                 }
             }
         }
         alert("成功了 恭喜 !");
    }

    function checkPositionValid(x,y,sudoku) {
        if (x < 0 || y < 0 || x > 8 || y > 8 || sudoku[x][y]==0) {
            return false
        }

        //行列重复检测
        for (var i = 0; i < 9; i++) {
            if ((i != y && sudoku[x][i] == sudoku[x][y]) || (i != x && sudoku[i][y] == sudoku[x][y])) {
                return false;
            }
        }

        //1.获取单元格起始位置
        var startX = parseInt((x / 3)) * 3;
        var startY = parseInt((y / 3)) * 3;
        for (var xx = startX; xx < startX + 3; xx++) {
            for (var yy = startY; yy < startY + 3; yy++) {
                if (xx != x && yy != y && sudoku[x][y] == sudoku[xx][yy]) {
                    return false;
                }
            }
        }
        return true;
    }

    $(document).ready(function () {
        var x =0;
        var y =0;
        //画九宫格
        $(".sudoku-table").find("td").each(function () {

            var altX = x<3?x:parseInt(x%3);
            var altY = (parseInt(y/9) < 3)?parseInt(y/9):(parseInt(y/9)%3);
            if(altX===2){
                $(this).css("border-right-color","#ff291a").css("border-right-width","5px");
            }
            if(altX===0){
                $(this).css("border-left-color","#ff291a").css("border-left-width","5px");
            }
            if(altY===0){
                $(this).css("border-top-color","#ff291a").css("border-top-width","5px");
            }
            if(altY===2){
                $(this).css("border-bottom-color","#ff291a").css("border-bottom-width","5px");
            }
            x+=1;
            y+=1;
        });
    })
</script>
</html>