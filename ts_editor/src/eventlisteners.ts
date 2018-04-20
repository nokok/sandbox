import {editor} from './codemirror';
import {consoleArea} from './dom';

editor.save = function () {
    localStorage.setItem("SaveData", editor.getValue());
};

window.addEventListener("error", function (event: ErrorEvent) {
    consoleArea.innerText = event.message;
});
