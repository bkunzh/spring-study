/**
 * Created by Administrator on 2018/3/1.
 */

function getByClass(oParent, name) {
    var arr = oParent.getElementsByTagName('*');
    var result = [];
    for(var i=0; i<arr.length; i++) {
        if(arr[i].className == name) {
            result.push(arr[i]);
        }
    }
    return result;
}

window.onload = function () {
    var oDiv_footer = document.getElementById('footer');
    var img_caret = getByClass(oDiv_footer, 'caret')[0];
    var aA = oDiv_footer.getElementsByTagName('a');
    var oUl = document.getElementById('ul1');
    var aLis = oUl.getElementsByTagName('li');
    var arr_loc = [];
    var timer = null;

    for(var i=0; i<aLis.length; i++) {
        arr_loc.push(aLis[i].offsetLeft);
    }
    for(var i=0; i<aLis.length; i++) {
        aLis[i].style.position = 'absolute';
        aLis[i].style.left = arr_loc[i] + 'px';
    }

    aA[1].onclick = function () {
        var iNow = 0;
        //递归
        clearTimeout(timer);
        function next() {
            if(iNow < aLis.length/2) {
                miaovStartMove(aLis[iNow], {left: -200},  MIAOV_MOVE_TYPE.FLEX);
                timer = setTimeout(next, 100);         //递归！！
                iNow++;
            }
            else if(iNow = aLis.length/2) {
                timer = setTimeout(next2, 100);
            }
        }
        function next2() {
            if(iNow < aLis.length) {
                miaovStartMove(aLis[iNow], {left: arr_loc[iNow-6]},  MIAOV_MOVE_TYPE.FLEX);
                timer = setTimeout(next2, 100);
                iNow++;
            }
        }

        next();
        aA[0].className = '';
        aA[1].className = 'show';
        miaovStartMove(img_caret, {left: 530}, MIAOV_MOVE_TYPE.BUFFER);
    }





    aA[0].onclick = function () {
        var iNow = aLis.length-1;
        //递归
        clearTimeout(timer);
        function next() {
            if(iNow >= aLis.length/2) {
                miaovStartMove(aLis[iNow], {left: 1000},  MIAOV_MOVE_TYPE.FLEX);
                timer = setTimeout(next, 100);         //递归！！
                iNow--;
            }
            else if(iNow = aLis.length/2-1) {
                timer = setTimeout(next2, 100);
            }
        }
        function next2() {
            if(iNow >= 0) {
                miaovStartMove(aLis[iNow], {left: arr_loc[iNow]},  MIAOV_MOVE_TYPE.FLEX);
                timer = setTimeout(next2, 100);
                iNow--;
            }
        }

        next();
        aA[1].className = '';
        aA[0].className = 'show';
        miaovStartMove(img_caret, {left: 420}, MIAOV_MOVE_TYPE.BUFFER);
    }
}