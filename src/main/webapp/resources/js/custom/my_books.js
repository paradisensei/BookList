$(document).ready(function() {
    $('.remove').click(function() {
        var panel = $(this).closest('.panel');
        var book_id = panel.find('.book').val();
        $.ajax({
            url: '/books/my/' + book_id,
            type: 'delete',
            success: function () {
                panel.hide();
            }
        });
    });
});