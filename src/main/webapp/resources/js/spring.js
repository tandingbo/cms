window.onload = function () {
    // 获取元素
    var page1 = document.getElementById("page1");
    var page2 = document.getElementById("page2");
    var page3 = document.getElementById("page3");

    var music = document.getElementById("music");
    var audio = document.getElementsByTagName("audio")[0];

    // 音乐播放完停止时,自动停止光盘旋转效果
    audio.addEventListener("ended", function (event) {
        music.setAttribute("class", "");
    }, false);

    // 点击音乐图标,控制音乐播放效果
    music.addEventListener("touchstart", function (event) {
        if (audio.paused) {
            // 开始播放
            audio.play();
            // 开始动画
            music.setAttribute("class", "play");
        } else {
            // 暂停播放
            audio.pause();
            // 暂停动画
            music.setAttribute("class", "");
        }
    }, false);

    page1.addEventListener("touchstart", function (event) {
        page1.style.display = "none";
        page2.style.display = "block";
        page3.style.display = "block";
        page3.style.top = "100%";

        setTimeout(function () {
            page2.setAttribute("class", "page fadeOut");
            page3.setAttribute("class", "page fadeIn");
        }, 5500);
    }, false);

};