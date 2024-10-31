<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>


<style>
  

    .container {
        max-width: 400px;
        margin: 50px auto;
        padding: 20px;
        background-color: white;
        box-shadow: 0px 4px 8px rgba(0, 0, 0, 1); /* Adding shadow for depth */
        border-radius: 10px;
    }

    h1 {
        color: black;
        text-align: center;
        margin-bottom: 20px;
    }

    a {
        color: #007bff;
        text-decoration: none;
        font-weight: bold;
    }

    a:hover {
        color: #0056b3;
        text-decoration: underline;
    }

    .container p {
        font-size: 16px;
        line-height: 1.6;
        text-align: center;
        color: #8b8c8c;
        font-weight: bold;
    }

</style>

    <div class="container">
        <h1>Welcome, ${name}</h1>
        <p><a href="list-todo">Manage </a> your todos</p>
    </div>

<%@ include file="common/footer.jspf"%>
