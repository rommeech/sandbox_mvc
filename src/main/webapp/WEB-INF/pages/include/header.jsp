<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<header id="header">
    <div id="logo">
        <h1>Sandbox MVC</h1>
    </div>

    <script>
        var navigationItems = [
            { href: "<spring:url value='/feeds/'/>", title: "<spring:message text="Feeds"/>" },
            { href: "<spring:url value='/bots/'/>", title: "<spring:message text="Bots"/>" },
            { href: "<spring:url value='/channels/'/>", title: "<spring:message text="Channels"/>" },
        ];

        Vue.component('navigation-menu', {
            props: [ 'items' ],
            template: '<div><navigation-menu-item v-for="item in items" v-bind:item="item" v-bind:key="item.href"></navigation-menu-item></div>'
        });

        Vue.component('navigation-menu-item', {
            props: [ 'item' ],
            template: '<a v-bind:href="item.href" v-bind:class="getNavigationClass(item)">{{ item.title }}</a>',
            methods: {
                getNavigationClass: function(item) {
                    console.log(item.href)
                    console.log(window.location.href)
                    return window.location.href.indexOf(item.href) !== -1 ? "active" : ""
                }
            }
        });

        window.onload = function (ev) {
            var vmNavigation = new Vue({
                el: '#header_nav',
                data: {
                    items: navigationItems
                }
            })
        }

    </script>

    <nav id="header_nav">
        <navigation-menu v-bind:items="items"></navigation-menu>
    </nav>

    <!-- nav id="header_nav">
        <a href="<spring:url value='/feeds/'/>" id="mainMenuFeeds"><spring:message text="Feeds"/></a>
        <a href="<spring:url value='/bots/'/>"  id="mainMenuBots" v-bind:class="getClass(this.id)"><spring:message text="Bots"/></a>
        <a href="<spring:url value='/channels/'/>" id="mainMenuChannels"><spring:message text="Channels"/></a>
    </nav -->
</header>
