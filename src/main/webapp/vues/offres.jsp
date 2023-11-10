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
        exigences: 'Software Developer',
        remarques: 'Exciting opportunity for a software developer...',
        competences: 'University of Tech',
    },
    {
        exigences: 'Data Scientist',
        remarques: 'Join our team as a data scientist and work on cutting-edge projects...',
        competences: 'Data Science Institute',
    }
]}">
    <template x-for="offer in jobOffers" :key="offer.id">
        <div class="job-card">
            <h2 x-text="offer.exigences"></h2>
            <p x-text="offer.remarques"></p>
            <small x-text="`competences: ${offer.competences}`"></small>
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
