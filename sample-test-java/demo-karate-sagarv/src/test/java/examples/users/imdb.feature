Feature: Get All Movies info from IMDB

  Background:
    * url 'https://api.tvmaze.com/'

    Scenario: Search existing Show
      Given path 'search/shows'
      And param q = 'Sacred Games'
      When method get
      Then status 200
      And print response
      And match response[0].show.language == "Hindi"
      And match response[0].show.webChannel.name == 'Netflix'

      * def first = response[0]