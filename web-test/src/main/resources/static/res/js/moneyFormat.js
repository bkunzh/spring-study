$(function () {
    if (('undefined' != typeof pageType) && pageType == 'add') {
        return;
    }
    $('span.moneyFormat').text(function (i, text) {
        console.log('span.moneyFormat i=', i, 'text=', text);
        if (text) {
            return formatNumber(text);
        } else {
            return '0.00';
        }
    });
    $('input.moneyFormat').val(function (i, text) {
        console.log('input.moneyFormat i=', i, 'text=', text);
        if (text) {
            return formatNumber(text);
        } else {
            return '0.00';
        }
    });
    $('textarea.moneyFormat').val(function (i, text) {
        console.log('textarea.moneyFormat i=', i, 'text=', text);
        if (text) {
            return formatNumber(text);
        } else {
            return '0.00';
        }
    });
    $('td.moneyFormat').text(function (i, text) {
        if (text) {
            return formatNumber(text);
        } else {
            return '0.00';
        }
    });

    function formatNumber(text) {
        try {
            return Number(text).toFixed(2);
        } catch (e) {
            console.error(e);
            return text;
        }
    }
});