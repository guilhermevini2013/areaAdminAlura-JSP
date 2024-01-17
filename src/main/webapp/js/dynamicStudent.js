function incrementPage(paramName,id) {
    var link = document.getElementById(id);
    var currentUrl = window.location.href;
    if (currentUrl.includes(paramName)) {
        currentUrl = currentUrl.replace(new RegExp('(' + paramName + '=)(\\d+)'), function(match, p1, p2) {
            return p1 + (parseInt(p2, 10) + 1);
        });
    } else {
        currentUrl += (currentUrl.includes('?') ? '&' : '?') + paramName + '=1';
    }
    link.href = currentUrl;
    console.log(link.href)
}
function unIncrementPage(paramName,id) {
    var link = document.getElementById(id);
    var currentUrl = window.location.href;
    if (currentUrl.includes(paramName)) {
        currentUrl = currentUrl.replace(new RegExp('(' + paramName + '=)(\\d+)'), function(match, p1, p2) {
            if (p2<=0){
                return p1 + parseInt(p2, 10);
            }else {
                return p1 + (parseInt(p2, 10) - 1);
            }
        });
    } else {
        currentUrl += (currentUrl.includes('?') ? '&' : '?') + paramName + '=1';
    }
    link.href = currentUrl;
}


