/* 
 * 通用工具集
 * @author muqin_deng
 * @time 2015/01/08
 */
(function (window, undefined) {
			    
    //天，时，分，秒的毫秒数
    var ONE_SECOND = 1000,
        ONE_MINUTE = ONE_SECOND * 60,
        ONE_HOUR = ONE_MINUTE * 60,
        ONE_DAY = ONE_HOUR * 24;

    var timeGone = function (infoObj) {
        

        var now = new Date(),
            currYear = now.getFullYear(),                                       //当前年
            currMonDays = new Date(currYear, now.getMonth() + 1, 0).getDate(),  //当前月的总天数
            firstDay = new Date(currYear, 0, 1),                                //当前年的第一天
            lastDay = new Date(currYear, 11, 31),                               //当前年的最后一天
            oneYearDays = lastDay.getTime() - firstDay.getTime() + ONE_DAY;     //当前年的总毫秒数

        var compareArr = [
                {'type': 'year', 'time': oneYearDays},
                {'type': 'month', 'time': currMonDays * ONE_DAY},
                {'type': 'day', 'time': ONE_DAY},
                {'type': 'hour', 'time': ONE_HOUR},
                {'type': 'minute', 'time': ONE_MINUTE},
                {'type': 'second', 'time': ONE_SECOND}
            ],
            info = {
            	'year': '年',
            	'month': '个月',
            	'day': '天',
            	'hour': '小时',
            	'minute': '分钟',
            	'second': '秒'
            },
            i = 0,
            differ = Math.abs(now.getTime() - this.getTime()),    //传入时间与当前时间的毫秒差值
            result = 0;
        
        //从年开始算，不满1就继续往下推，大于等于1就结束
        while (result < 1 && i < compareArr.length) {
            result = differ / compareArr[i].time;
            i++;
        }
        
        var type = compareArr[i-1].type;
        
        result = Math.floor(result) === 0 ? 1 : Math.floor(result);

        return result + (infoObj && infoObj[type] ? infoObj[type] : info[type]) + '前';
    };
    
    Date.prototype.timeGone = timeGone;
	
})(window);

function encodeQueryData(data) {
    var ret = [];
    for (let d in data)
        ret.push(encodeURIComponent(d) + '=' + encodeURIComponent(data[d]));
    return ret.join('&');
}

// 获取简单对象，只包括属性
function getSimpleObject(obj) {
    var rs = {};
    for (let key of Object.keys(obj)) {
        if (obj[key]) {
            rs[key] = obj[key];
        }
    }
    return rs;
}

function removeSessionStorage() {
    for (let key of Object.keys(sessionStorage)) {
        sessionStorage.removeItem(key);
    }
}