# VoteGR -  *Vote Securely*

> Democracy is government of, by, and for the people.
>
>  &mdash; <cite>Abraham Lincoln</cite>

### Η Ελληνική έκδοση του README είναι διαθέσιμη [ΕΔΩ](https://github.com/geras-papax/VoteGR/blob/main/README_gr.md)


<p align="center">
  <img src="https://github.com/geras-papax/VoteGR/blob/main/images/logo.png" width="300" height="300" alt="Logo">
</p>


## :dart: Introduction :dart:

The present repository is our project for the Software Engineering Course of the [Department of Computer Engineering & Informatics](https://www.ceid.upatras.gr/en).


## :question: Description :question:

The application is addressed to three types of users: Citizen, Party and Administrator. <br>
The citizen can vote and see the results of referendums held by the state. The political views of the Parliament parties are also available on the platform. These views can be posted by the party directly in the application or automatically crawled from the parties' Twitter account. The administrator can create referendums and grant voting rights only to the parties that belong to the Parliament after the national elections. Every citizen can enter the platform through the TAXISnet system to ensure the integrity of the process, while the login of the party is authenticated using the official Twitter API.

## :hammer: Architecture :hammer:

<p align="center">
  <img src="https://github.com/geras-papax/VoteGR/blob/main/images/system_architecture.png" alt="System Architecture">
</p>

The above diagram presents the project's architecture. In detail:
- Android Application: implemented via Android Studio and simulated using Android Virtual Device (AVD). The HTTP Requests were sent using the library recommended by Google, Volley.
- PHP API: implemented via the web server Apache. The API is responsible for sending the SQL queries to the database and return back the results in JavaScript Object Notation (JSON) format, the most used file and data interchange format used to transmit data between browser and server.
- MySQL Database: implemented via phpMyAdmin, an open source tool written in PHP, that allows the management of the MySQL database through the web. It is designed in a way that the queries can be executed easily and rapidly.


## :family: Team :family:
- [Michail Karavokyris](https://github.com/karavokyrismichail)
- [Agisilaos Kounelis](https://github.com/kounelisagis)
- [Ioannis Koutsocheras](https://github.com/koutsocheras99)
- [Gerasimos Papachronopoulos](https://github.com/geras-papax)


## :zap: GitHub Workflow :zap:

Our main goal was that our code modifications wouldn't affect the main branch. For this reason the repository owner (Papachronopoulos) created a branch for each deliverable and applied his changes there. The rest team members (Karavokyris, Koutsocheras, Kounelis) forked the repository and worked only on their forks, making sure that they were up to date with the original repo (regularly fetch and merge from the upstream).


When a member had finished with the part he had undertaken, he had to open a pull request to the main branch so that another member of the team could examine it and merge it if the changes were correct. We made sure that the messages that accompany each commit are descriptive of the changes that have been made. In this way one can see the commits and identify when and how the changes were made to the code. In short, the way we worked is a combination of Forking Workflow and Branch Workflow.

It is worth noting that in a further effort to make thing easier for the team, the capabilities of GitHub were used to define Reviewers, Assignees and Labels for our pull requests. As an equally good practice, issues were used in the project. Each issue was closed with the appropriate pull request. As in the pull requests, the options for Assignees and Labels were also used for the issues.



The links of the project's branches:
- [Main Branch](https://github.com/geras-papax/VoteGR/tree/main)
- [Branch 1](https://github.com/geras-papax/VoteGR/tree/%CE%A0%CE%91%CE%A1%CE%91%CE%94%CE%9F%CE%A4%CE%95%CE%91_2_11/04%2F21)
- [Branch 2](https://github.com/geras-papax/VoteGR/tree/%CE%A0%CE%91%CE%A1%CE%91%CE%94%CE%9F%CE%A4%CE%95%CE%91_3_25/04%2F21)
- [Branch 3](https://github.com/geras-papax/VoteGR/tree/%CE%A0%CE%91%CE%A1%CE%91%CE%94%CE%9F%CE%A4%CE%95%CE%91_4_23/05%2F21)
- [Branch 4](https://github.com/geras-papax/VoteGR/tree/%CE%A0%CE%91%CE%A1%CE%91%CE%94%CE%9F%CE%A4%CE%95%CE%91_5_06/06%2F21)
- [Branch 5](https://github.com/geras-papax/VoteGR/tree/%CE%A0%CE%91%CE%A1%CE%91%CE%94%CE%9F%CE%A4%CE%95%CE%91_6_11/06%2F21)

The links of the project's forks:
- [Michail Karavokyris](https://github.com/karavokyrismichail/VoteGR)
- [Agisilaos Kounelis](https://github.com/kounelisagis/VoteGR)
- [Ioannis Koutsocheras](https://github.com/koutsocheras99/VoteGR)



## :wrench: Tools :wrench:

- [Android Studio](https://developer.android.com/studio) - [Volley Library](https://developer.android.com/training/volley)
- [XAMPP (Apache + MySQL)](https://www.apachefriends.org/index.html)
- [Visual Studio Code](https://code.visualstudio.com/) - [Live Share Extension](https://marketplace.visualstudio.com/items?itemName=MS-vsliveshare.vsliveshare)


## :arrow_forward: Run :arrow_forward:
- Via Android Studio: Android Application Build and Run
- Via XAMPP: build MySQL database and PHP interpret

> Note: The address `http: // 192.168.2.4` has been used in the Android Studio code to send HTTP requests. This may require a change to another IP address accessible from your home network.

