$(document).ready(function() {
    $('.add').click(function() {
        var panel = $(this).closest('.panel');
        var book_id = panel.find('.book').val();
        console.log(book_id);
        $.ajax({
            url: '/books/my/' + book_id,
            type: 'post',
            success: function () {
                panel.hide();
            }
        });
    });
});