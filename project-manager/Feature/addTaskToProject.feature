Feature: Добавяне на задача към проект
      
	Scenario: Създаване на задача в проект
    Given Потребителят е на екрана за създаване на задача
    And Потребителят има проект "TestProject1"
    When Потребителят премахва всички задачи
    And Потребителят въвежда име на задача "TestTask1"
    And Потребителят въвежда име на проект "TestProject1" в който да е задачата
    And Натиска бутона за създаване на задача
    Then Броя задачите в проекта е "1"
    
  Scenario: Създаване на задача в проект
    Given Потребителят е на екрана за създаване на задача
    And Потребителят има проект "TestProject1"
    When Потребителят премахва всички задачи
    And Потребителят въвежда име на задача "TestTask1"
    And Потребителят въвежда име на проект "TestProject1" в който да е задачата
    And Натиска бутона за създаване на задача
    And Потребителят въвежда име на задача "TestTask2"
    And Потребителят въвежда име на проект "TestProject1" в който да е задачата
    And Натиска бутона за създаване на задача
    Then Броя задачите в проекта е "2"
    
  Scenario: Създаване на задача в проект
    Given Потребителят е на екрана за създаване на задача
    And Потребителят има проект "TestProject1"
    When Потребителят премахва всички задачи
    And Потребителят въвежда име на задача "TestTask1"
    And Потребителят въвежда име на проект "TestProject1" в който да е задачата
    And Натиска бутона за създаване на задача
    And Потребителят въвежда име на задача "TestTask2"
    And Потребителят въвежда име на проект "TestProject1" в който да е задачата
    And Натиска бутона за създаване на задача
    Then Броя задачите в проекта е "2"
    