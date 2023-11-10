<%--
  Created by IntelliJ IDEA.
  User: aland
  Date: 10/11/2023
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Offres</title>
</head>
<body>
<div class="grid-container" x-data="{ jobOffers: [
    {
        title: 'Software Developer',
        description: 'Exciting opportunity for a software developer...',
        school: 'University of Tech',
        postedDate: '2023-11-10'
    },
    {
        Exigences: 'Data Scientist',
        description: 'Join our team as a data scientist and work on cutting-edge projects...',
        school: 'Data Science Institute',
        postedDate: '2023-11-09'
    }
]}">
    <template x-for="offer in jobOffers" :key="offer.id">
        <div class="job-card">
            <h2 x-text="offer.title"></h2>
            <p x-text="offer.description"></p>
            <small x-text="`Ecole: ${offer.school}`"></small><br>
            <small x-text="`Exigences: ${offer.school}`"></small><br>
            <small x-text="`Remarques: ${offer.remarques}`"></small><br>
            <small x-text="`Competences: ${offer.competences}`"></small><br>
            <small x-text="`Posted Date: ${offer.postedDate}`"></small>
        </div>
    </template>

<script>
/*    function fetchJobOffers() {
        // Make a request to your API endpoint to get job offers
        fetch('/offre')
            .then(response => response.json())
            .then(data => {
                // Set the job offers in the Alpine.js data
                Alpine.data('jobOffers', () => data);
            })
            .catch(error => console.error('Error fetching job offers:', error));
    }
 */
</script>

</div>

</body>
</html>
