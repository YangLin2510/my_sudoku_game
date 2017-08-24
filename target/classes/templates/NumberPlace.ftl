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
                <tr>
                    <td>1</td>
                    <td>2</td>
                    <td>3</td>
                    <td>4</td>
                    <td>5</td>
                    <td>6</td>
                    <td>7</td>
                    <td>8</td>
                    <td>9</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>2</td>
                    <td>3</td>
                    <td>4</td>
                    <td>5</td>
                    <td>6</td>
                    <td>7</td>
                    <td>8</td>
                    <td>9</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>2</td>
                    <td>3</td>
                    <td>4</td>
                    <td>5</td>
                    <td>6</td>
                    <td>7</td>
                    <td>8</td>
                    <td>9</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>2</td>
                    <td>3</td>
                    <td>4</td>
                    <td>5</td>
                    <td>6</td>
                    <td>7</td>
                    <td>8</td>
                    <td>9</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>2</td>
                    <td>3</td>
                    <td>4</td>
                    <td>5</td>
                    <td>6</td>
                    <td>7</td>
                    <td>8</td>
                    <td>9</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>2</td>
                    <td>3</td>
                    <td>4</td>
                    <td>5</td>
                    <td>6</td>
                    <td>7</td>
                    <td>8</td>
                    <td>9</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>2</td>
                    <td>3</td>
                    <td>4</td>
                    <td>5</td>
                    <td>6</td>
                    <td>7</td>
                    <td>8</td>
                    <td>9</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>2</td>
                    <td>3</td>
                    <td>4</td>
                    <td>5</td>
                    <td>6</td>
                    <td>7</td>
                    <td>8</td>
                    <td>9</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>2</td>
                    <td>3</td>
                    <td>4</td>
                    <td>5</td>
                    <td>6</td>
                    <td>7</td>
                    <td>8</td>
                    <td>9</td>
                </tr>
            </table>
        </div>

        <div class="col-md-2 game-info-div">
            <div class="game-time">00:00</div>
            <div>
                <button class="btn btn-danger btn-block">重新开始</button>
            </div>
            <div>
                <button class="btn btn-success btn-block">检查结果</button>
            </div>
        </div>
    </div>
</div>
</body>
<script src="webjars/jquery/2.1.3/jquery.min.js"></script>
<script>
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
    }, 1000)
</script>
</html>