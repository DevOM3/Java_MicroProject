<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SPS | Playground</title>
        <style type="text/css">
            <%@include file="css/playground.css" %>
        </style>
    </head>
    <body>
        <section class="playground-section">
            <div class="top"/>
            <img id="ai-response" src="https://firebasestorage.googleapis.com/v0/b/chatsharp-dbfc9.appspot.com/o/icon.png?alt=media&token=2ee66a1c-336b-46da-a561-58682c48b8fb" alt="" />
            </div>
            <div class="center">
                <table>
                    <tbody>
                        <tr>
                            <td>Match Number</td>
                            <td>Winner</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td id="match-1"></td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td id="match-2"></td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td id="match-3"></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="bottom">
                <button class="button" data-option="Stone"  onclick="handleButtonClick(this)">
                    <img 
                        src="https://firebasestorage.googleapis.com/v0/b/chatsharp-dbfc9.appspot.com/o/stone.png?alt=media&token=af3a0a57-8712-459d-9f74-8812d3190f5e"
                        alt=""
                        onmouseover="this.src = 'https://firebasestorage.googleapis.com/v0/b/chatsharp-dbfc9.appspot.com/o/stone-hand.png?alt=media&token=d61af72d-5fc3-4ef4-81a9-94d04b98c578';"
                        onmouseout="this.src = 'https://firebasestorage.googleapis.com/v0/b/chatsharp-dbfc9.appspot.com/o/stone.png?alt=media&token=af3a0a57-8712-459d-9f74-8812d3190f5e';"
                    />
                    <p>Stone</p>
                </button>
                <button class="button" data-option="Paper"  onclick="handleButtonClick(this)">
                    <img 
                        src="https://firebasestorage.googleapis.com/v0/b/chatsharp-dbfc9.appspot.com/o/paper.png?alt=media&token=85504b82-656a-46b8-8537-dc2acf343407"
                        alt=""
                        onmouseover="this.src = 'https://firebasestorage.googleapis.com/v0/b/chatsharp-dbfc9.appspot.com/o/paper-hand.png?alt=media&token=ffd7c467-11e8-436a-bed2-2b715bad8171';"
                        onmouseout="this.src = 'https://firebasestorage.googleapis.com/v0/b/chatsharp-dbfc9.appspot.com/o/paper.png?alt=media&token=85504b82-656a-46b8-8537-dc2acf343407';"
                    />
                    <p>Paper</p>
                </button>
                <button class="button" data-option="Scissor" onclick="handleButtonClick(this)">
                    <img 
                        src="https://firebasestorage.googleapis.com/v0/b/chatsharp-dbfc9.appspot.com/o/scissor.png?alt=media&token=81b7c7e1-0fd4-4fb5-9753-6ab1e68fef7c"
                        alt=""
                        onmouseover="this.src = 'https://firebasestorage.googleapis.com/v0/b/chatsharp-dbfc9.appspot.com/o/scissor-hand.png?alt=media&token=60535711-4e28-4fbd-8293-815087a81840';"
                        onmouseout="this.src = 'https://firebasestorage.googleapis.com/v0/b/chatsharp-dbfc9.appspot.com/o/scissor.png?alt=media&token=81b7c7e1-0fd4-4fb5-9753-6ab1e68fef7c';"
                    />
                    <p>Scissor</p>
                </button>
            </div>
        </section>
    </body>
    <script>
        <%@include file="js/playground.js" %>
    </script>
</html>
