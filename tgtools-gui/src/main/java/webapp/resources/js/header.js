window.onload = function (ev) {
    var vmHeader = new Vue({
        el: '#header',
        data: {},
        methods: {
            getClass: function(id) {
                console.log(id)
                return 'active'
            }
        }
    });
}

