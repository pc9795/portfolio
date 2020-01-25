var counter = 0;

$(document).on('click', '#start', function () {
    $(this).attr("hidden", true);
    $("#poem").attr("hidden", false);
    $("#show").attr("hidden", false);
});

$(document).on('click', "#show", function () {
    if (counter === 0) {
        $(this).text("PAKKA!!!");
        counter++;
    } else if (counter === 1) {
        $(this).text("NO CHEATING!!!");
        counter++;
    } else if (counter === 2) {
        $(this).text("MEHNAT LAGI THI, PADH LO!!!");
        counter++;
    } else if (counter === 3) {
        $(this).text("OKAY, GO ON!!!");
        counter++;
    } else if (counter === 4) {
        $('.space').attr("hidden", false);
        $(".firstWord").css('color', '#f26968');
        $(this).attr('hidden', 'hidden');
    }
});