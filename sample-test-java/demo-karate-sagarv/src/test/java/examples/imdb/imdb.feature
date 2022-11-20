Feature: Get All Movies info from IMDB

  Background:
    * url 'https://api.tvmaze.com/'
    * def payload = read('newuser.json')


    Scenario: Search existing Show
      Given path 'search/shows'
      And param q = 'Sacred Games'
      When method get
      Then status 200
      And print response
      And match response[0].show.language == "Hindi"
      And match response[0].show.webChannel.name == 'Netflix'

      * def first = response[0]

Scenario: create a user and then get it by id
    
    Given url 'https://jsonplaceholder.typicode.com/users'
    And request payload
    When method post
    Then status 201

    * def id = response.id
    * print 'created id is: ', id      