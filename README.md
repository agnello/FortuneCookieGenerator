# FortuneCookieGenerator
Interview Challenge DONE

Tasks to be completed:
1) Fix blocker issue that's currently causing all requests to return same fortune cookie instead of new ones.
Steps to reproduce issue:
· Run application by executing 'mvn spring-boot:run'
· Fire a GET request against http://localhost:8080/generateFortuneCookie?client=Barney&company=SuperStore
· Fire a GET request against http://localhost:8080/generateFortuneCookie?client=Sarah&company=MegaMarket
· Verify that both requests are returning same fortune cookie, which is not expected.

2) Add a code comment on changed code so that other developers understand what was root cause of the blocker issue.

2) Create a Junit test in order to verify new version of application is working as expected and blocker issue is not
happening anymore.

3) Create a Git patch with your changes, upload it to any public url and paste the public url as answer to the
 related pre-interview form question.
