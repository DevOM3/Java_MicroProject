<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SPS | Home</title>
        <style type="text/css">
            <%@include file="css/home.css" %>
        </style>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <main>
            <div class="container">
                <div class="welcome-div">
                    <h2 class="welcome">
                        Welcome to
                    </h2>
                </div>
                <div class="content">
                    <h1><div class="start-div">SPS<div class="end">.live</div></div></h1>
                    <p>
                      Play Stone Paper Scissor on the go.
                    </p>
                </div>
            </div>
        </main>
    </body>
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.6.1/gsap.min.js"
      integrity="sha512-cdV6j5t5o24hkSciVrb8Ki6FveC2SgwGfLE31+ZQRHAeSRxYhAQskLkq3dLm8ZcWe1N3vBOEYmmbhzf7NTtFFQ=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    ></script>
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.6.1/CSSRulePlugin.min.js"
      integrity="sha512-0bzaetZStCnsUgbCtGVxftzF/L32PNOnrMlYLXwBOKl8cUjTSSDfJVyyJsNwGoI0iE0WUqni2eEfO35kJjFj5g=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    ></script>

    <script>
      const border = CSSRulePlugin.getRule(".content:before");
      const h1 = document.querySelector("h1");
      const p = document.querySelector("p");
      const timeline = gsap.timeline();

      timeline.from(border, {
        delay: 0.5,
        duration: 4,
        cssRule: { scaleX: 0 },
      });
      timeline.to(
        h1,
        {
          duration: 2,
          clipPath: "polygon(0 0, 100% 0, 100% 100%, 0% 100%)",
          y: "30px",
        },
        "-=3"
      );
      timeline.to(
        p,
        {
          duration: 4,
          delay: 2,
          clipPath: "polygon(0 0, 100% 0, 100% 100%, 0% 100%)",
        },
        "-=2"
      );
    </script>
</html>
