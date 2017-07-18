app.controller('homeCtrl', function ($scope, homeService) {
    $scope.a = '1111';

    $scope.login = function () {
        event.preventDefault();
        $('form').fadeOut(500);
        $('.wrapper').addClass('form-success');
    }
});
