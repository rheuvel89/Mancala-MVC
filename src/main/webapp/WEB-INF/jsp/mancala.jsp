<!DOCTYPE html>
<html>
	<head>
		<title>Mancala</title>
        <link rel="stylesheet" href="../css/mancala.css">
	</head>
	<body>
	    <jsp:useBean id="mancala" class="nl.sogyo.mancala.MancalaData" scope="request"/>
        <div class="center" >
            <h1>Mancala</h1>
            <table class=board>
                <tr>
                    <td rowspan="3">
                        <button class="button kalaha2" id="kalaha2">
                            <jsp:getProperty name="mancala" property="kalaha2Count"/>
                        </button>
                    </td>
                    <td>
                       <form action="/mancala-mvc/mancala/12" method="post" target="">
                            <button class="button bowl2" id="bowl12">
                                <jsp:getProperty name="mancala" property="bowl12Count"/>
                            </button>
                        </form>
                    </td>
                    <td>
                       <form action="/mancala-mvc/mancala/11" method="post" target="">
                            <button class="button bowl2" id="bowl11">
                                <jsp:getProperty name="mancala" property="bowl11Count"/>
                            </button>
                        </form>
                    </td>
                    <td>
                       <form action="/mancala-mvc/mancala/10" method="post" target="">
                            <button class="button bowl2" id="bowl10">
                                <jsp:getProperty name="mancala" property="bowl10Count"/>
                            </button>
                        </form>
                    </td>
                    <td>
                       <form action="/mancala-mvc/mancala/9" method="post" target="">
                            <button class="button bowl2" id="bowl9">
                                <jsp:getProperty name="mancala" property="bowl9Count"/>
                            </button>
                        </form>
                    </td>
                    <td>
                       <form action="/mancala-mvc/mancala/8" method="post" target="">
                            <button class="button bowl2" id="bowl8">
                                <jsp:getProperty name="mancala" property="bowl8Count"/>
                            </button>
                        </form>
                    </td>
                    <td>
                       <form action="/mancala-mvc/mancala/7" method="post" target="">
                            <button class="button bowl2" id="bowl7">
                                <jsp:getProperty name="mancala" property="bowl7Count"/>
                            </button>
                        </form>
                    </td>
                    <td rowspan = "3">
                        <button class="button kalaha1" id="kalaha1">
                            <jsp:getProperty name="mancala" property="kalaha1Count"/>
                        </button>
                    </td>
                </tr>
                <tr>
                    <td columnspan = 6/>
                </tr>
                <tr>
                    <td>
                       <form action="/mancala-mvc/mancala/1" method="post" target="">
                            <button class="button bowl1" id="bowl1">
                                <jsp:getProperty name="mancala" property="bowl1Count"/>
                            </button>
                        </form>
                    </td>
                    <td>
                       <form action="/mancala-mvc/mancala/2" method="post" target="">
                            <button class="button bowl1" id="bowl2">
                                <jsp:getProperty name="mancala" property="bowl2Count"/>
                            </button>
                        </form>
                    </td>
                    <td>
                       <form action="/mancala-mvc/mancala/3" method="post" target="">
                            <button class="button bowl1" id="bowl3">
                                <jsp:getProperty name="mancala" property="bowl3Count"/>
                            </button>
                        </form>
                    </td>
                    <td>
                       <form action="/mancala-mvc/mancala/4" method="post" target="">
                            <button class="button bowl1" id="bowl4">
                                <jsp:getProperty name="mancala" property="bowl4Count"/>
                            </button>
                        </form>
                    </td>
                    <td>
                       <form action="/mancala-mvc/mancala/5" method="post" target="">
                            <button class="button bowl1" id="bowl5">
                                <jsp:getProperty name="mancala" property="bowl5Count"/>
                            </button>
                        </form>
                    </td>
                    <td>
                       <form action="/mancala-mvc/mancala/6" method="post" target="">
                            <button class="button bowl1" id="bowl6">
                                <jsp:getProperty name="mancala" property="bowl6Count"/>
                            </button>
                        </form>
                    </td>
                </tr>
            </table>
            <br/>
            <div>
                <form action="/mancala-mvc/mancala/restart" method="post" target="">
                    <button class="button restartButton" id="restartButton">New Game</button>
                </form>

                <h3><jsp:getProperty name="mancala" property="message"/></h3>
            </div>
        </div>
	</body>
</html>