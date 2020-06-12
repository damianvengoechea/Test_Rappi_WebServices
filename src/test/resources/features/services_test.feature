
Feature: service test wiht rest assured
  I as user
  I want to test the services
  to see the result

  @GET_ONE_USER
    Scenario Outline: GET SINGLE USER
      When Damian search a single user with <id>
      Then he should see the register the <email>
    Examples:
      | id | email                    |
      | 2  | janet.weaver@reqres.in   |
      | 5  | charles.morris@reqres.in |

  @PUT
    Scenario: test PUT - UPDATE
      When Damian performs an update with Name Damian and Job QAutomation
      Then he see response update job QAutomation

  @POST
    Scenario: POST REGISTER - SUCCESSFUL
      When Damian registers on the page with eve.holt@reqres.in and with password pistol
      Then user successfully created with token QpwL5tke4Pnpja7X4

