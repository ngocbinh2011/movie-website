$(document).ready(function() {
    $(".show-menu").click(function() {
        $(".menu").toggleClass("menushow")
    });
    $(".ms").click(function() {
        $(".searchx").toggleClass("mse")
    });
    $(".filterm").click(function() {
        $(".bigfilter").toggleClass("bigshow")
    })
});
var sf_templates = "<a href=\"{search_url_escaped}\">View All Results<\/a>";
var sf_position = '0';
var sf_input = '.search-live';
jQuery(document).ready(function() {
    jQuery(sf_input).ajaxyLiveSearch({
        "expand": !1,
        "searchUrl": "\/tim-kiem\/%s\/",
        "text": "Search",
        "delay": 500,
        "iwidth": 180,
        "width": 350,
        "ajaxUrl": "\/ajax\/search",
        "rtl": 0
    });
    jQuery(".live-search_ajaxy-selective-input").keyup(function() {
        var width = jQuery(this).val().length * 8;
        if (width < 50) {
            width = 50
        }
        jQuery(this).width(width)
    });
    jQuery(".live-search_ajaxy-selective-search").click(function() {
        jQuery(this).find(".live-search_ajaxy-selective-input").focus()
    });
    jQuery(".live-search_ajaxy-selective-close").click(function() {
        jQuery(this).parent().remove()
    })
})

