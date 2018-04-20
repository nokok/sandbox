const consoleArea = document.createElement("div");
consoleArea.id = "console";
document.getElementById("app").appendChild(consoleArea);
window["consoleArea"] = consoleArea;

export{consoleArea};