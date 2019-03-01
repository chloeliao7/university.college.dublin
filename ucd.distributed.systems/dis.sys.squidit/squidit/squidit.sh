
#!/bin/
function squid-web() {
  cd ~/Documents/igithub/gecbox.squidit/squidit/squidit-web/target;
  java -jar web-0.0.1-SNAPSHOT.jar;
};

#!/bin/
function squid-eur() {
  cd ~/Documents/igithub/gecbox.squidit/squidit/squidit-eureka/target;
  java -jar eureka-0.0.1-SNAPSHOT.jar;
};

#!/bin/
function squid-mong1() {
  cd ~/Documents/igithub/gecbox.squidit/squidit/squidit-mongo-server1/target
  java -jar mongo-server1-0.0.1.jar;
};

#!/bin/
function squid-mong2() {
  cd ~/Documents/igithub/gecbox.squidit/squidit/squidit-mongo-server2/target
  java -jar mongo-server2-0.0.1.jar;
};

#!/bin/
function squid-mong3() {
  cd ~/Documents/igithub/gecbox.squidit/squidit/squidit-mongo-server3/target
  java -jar mongo-server3-0.0.1.jar;
};

#!/bin/
function squid-vid() {
  cd ~/Documents/igithub/gecbox.squidit/squidit/squidit-video/target;
  java -jar mongo-server1-0.0.1.jar;
};

#!/bin/
function squid-kill() {
  pgrep -f -a 'iTerm2' | xargs kill
};

#!/bin/
function squid-mon() {
  cd ~/Documents/igithub/gecbox.squidit/squidit/squidit-monitor/;
  mvn clean install;
};

#!/bin/
function squid-main() {
  cd ~/Documents/igithub/gecbox.squidit/squidit;
  mvn clean install;
};

#!/bin/
function squid-build() {
  cd ~/Documents/igithub/gecbox.squidit/squidit/squidit-eureka/;
  mvn clean install;
  cd ~/Documents/igithub/gecbox.squidit/squidit/squidit-web/;
  mvn clean install;
  cd ~/Documents/igithub/gecbox.squidit/squidit/squidit-monitor/;
  mvn clean install;
  cd ~/Documents/igithub/gecbox.squidit/squidit/squidit-mongo-server1/;
  mvn clean install;
  cd ~/Documents/igithub/gecbox.squidit/squidit/squidit-mongo-server2/;
  mvn clean install;
  cd ~/Documents/igithub/gecbox.squidit/squidit/squidit-mongo-server3/;
  mvn clean install;
  cd ~/Documents/igithub/gecbox.squidit/squidit;
  mvn clean install;
  
};

#!/bin/
function squid-runall() {
  cd ~/Documents/igithub/gecbox.squidit/squidit/squidit-eureka/;
  mvn clean install;
  cd ~/Documents/igithub/gecbox.squidit/squidit/squidit-web/;
  mvn clean install;
  cd ~/Documents/igithub/gecbox.squidit/squidit/squidit-monitor/;
  mvn clean install;
  cd ~/Documents/igithub/gecbox.squidit/squidit/squidit-mongo-server1/;
  mvn clean install;
  cd ~/Documents/igithub/gecbox.squidit/squidit/squidit-mongo-server2/;
  mvn clean install;
  cd ~/Documents/igithub/gecbox.squidit/squidit/squidit-mongo-server3/;
  mvn clean install;
  
`osascript <<-AppleScript
tell application "iTerm"
  tell current window
  tell current session

  write text "echo Starting Servers ----------> "
  end tell

  create tab with profile "editermini"
  tell current session

    write text "cd ~/Documents/igithub/gecbox.squidit/squidit/squidit-eureka/target;"
    write text "	java -jar eureka-0.0.1-SNAPSHOT.jar;"
  end tell

delay 14

  -- create tab to run aioc server
  create tab with profile "editermini"

  tell current session
    write text "mongod"
  end tell

  -- create tab to run aioc server
  create tab with profile "editermini"

  tell current session
    write text "cd ~/Documents/igithub/gecbox.squidit/squidit/squidit-web/target;"
    write text "java -jar web-0.0.1-SNAPSHOT.jar;"
  end tell

  -- create tab to run aioc server
  create tab with profile "editermini"

  tell current session
    write text "cd ~/Documents/igithub/gecbox.squidit/squidit/squidit-mongo-server1/target"
    write text "java -jar mongo-server1-0.0.1.jar;"
  end tell

  tell current session
    write text "~/Documents/igithub/gecbox.squidit/squidit/squidit-mongo-server2/target"
    write text "java -jar mongo-server2-0.0.1.jar;"
  end tell

  tell current session
    write text "~/Documents/igithub/gecbox.squidit/squidit/squidit-mongo-server3/target"
    write text "java -jar mongo-server3-0.0.1.jar;"
  end tell

  tell current session
    write text "~/Documents/igithub/gecbox.squidit/squidit/squidit-monitor/target"
    write text "java -jar monitor-0.0.1-SNAPSHOT.jar;"

  end tell

  -- create tab to run aioc server
  create tab with profile "editermini"

delay 3

  -- create tab to run aioc server
  create tab with profile "editermini"
  tell current session

  write text "mongo"
  end tell

  tell last session of last tab
  end tell
  end tell
end tell
return quit
AppleScript`
}

#!/bin/
function squid-run() {
  
`osascript <<-AppleScript
tell application "iTerm"
  tell current window
  tell current session

  write text "echo Starting Servers ----------> "
  end tell

  create tab with profile "editermini"
  tell current session

    write text "cd ~/Documents/igithub/gecbox.squidit/squidit/squidit-eureka/target;"
    write text "	java -jar eureka-0.0.1-SNAPSHOT.jar;"
  end tell

delay 14

  -- create tab to run aioc server
  create tab with profile "editermini"

  tell current session
    write text "mongod"
  end tell

  -- create tab to run aioc server
  create tab with profile "editermini"

  tell current session
    write text "cd ~/Documents/igithub/gecbox.squidit/squidit/squidit-web/target;"
    write text "	java -jar web-0.0.1-SNAPSHOT.jar;"
  end tell

  -- create tab to run aioc server
  create tab with profile "editermini"
  tell current session
    write text "cd ~/Documents/igithub/gecbox.squidit/squidit/squidit-mongo-server1/target"
    write text "java -jar mongo-server1-0.0.1.jar;"
  end tell

  -- create tab to run aioc server
  create tab with profile "editermini"
  tell current session
    write text "~/Documents/igithub/gecbox.squidit/squidit/squidit-mongo-server2/target"
    write text "java -jar mongo-server2-0.0.1.jar;"
  end tell

  -- create tab to run aioc server
  create tab with profile "editermini"
  tell current session
    write text "~/Documents/igithub/gecbox.squidit/squidit/squidit-mongo-server3/target"
    write text "java -jar mongo-server3-0.0.1.jar;"
  end tell

  -- create tab to run aioc server
  create tab with profile "editermini"
  tell current session
    write text "~/Documents/igithub/gecbox.squidit/squidit/squidit-monitor/target"
    write text "java -jar monitor-0.0.1-SNAPSHOT.jar;"
  end tell

delay 3

  -- create tab to run aioc server
  create tab with profile "editermini"
  tell current session

  write text "mongo"
  end tell

  delay 1

  -- create tab to run aioc server
  create tab with profile "editermini"
  tell current session
  write text "/usr/bin/open -a '/Applications/Google Chrome.app' 'http://localhost:3333'"

  end tell
  delay 14

 close current tab

  tell last session of last tab
  end tell
  end tell
end tell
return quit
AppleScript`
}
