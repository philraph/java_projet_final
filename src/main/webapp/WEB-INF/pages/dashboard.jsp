<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html data-theme="light">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Dashboard</title>
  <script
          defer
          src="https://cdn.jsdelivr.net/npm/alpinejs@3.x.x/dist/cdn.min.js"
  ></script>
  <link
          rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css"
  />
  <link
          rel="stylesheet"
          href="https://picocss.com/docs/css/pico.docs.min.css"
  />
</head>
<body>
<nav class="container-fluid">
  <ul>
    <li></li>
    <li>
      AMiRE
    </li>
  </ul>
  <ul>
    <li>
      <a class="secondary" href="dashboard">${username}</a>
    </li>
    <li>
      <a class="secondary" href="logout">Se déconnecter</a>
    </li>
  </ul>
</nav>
<main class="container">
  <aside>
    <details>
      <summary>Utilisateurs</summary>
      <ul>
        <li>
          <a class="secondary" href="users">Liste des utilisateurs</a>
        </li>
        <li>
          <a class="secondary" href="users/create">Créer un utilisateur</a>
        </li>
      </ul>
    </details>
    <details>
      <summary>Ecoles</summary>
      <ul>
        <li>
          <a class="secondary" href="schools">Liste des écoles</a>
        </li>
        <li>
          <a class="secondary" href="schools/create">Créer une école</a>
        </li>
      </ul>
    </details>
    <details>
      <summary>Offres</summary>
      <ul>
        <li>
          <a class="secondary" href="offers">Liste des offres</a>
        </li>
        <li>
          <a class="secondary" href="offers/create">Créer une offre</a>
        </li>
      </ul>
    </details>
  </aside>
  <div role="document">
    <h1 x-data="{ message: 'I ❤️ Alpine' }" x-text="message"></h1>
  </div>
</main>
</body>
</html>
