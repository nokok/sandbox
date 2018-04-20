import * as CodeMirror from "codemirror";
import "codemirror/lib/codemirror.css";
import "codemirror/mode/javascript/javascript";
window["CodeMirror"] = CodeMirror;

const editor = CodeMirror(document.getElementById("editor"), {
    mode: "javascript",
    lineNumbers: true,
    value: `var foo = function() {
  return "Hello World!!!";
};

foo();`
});

window["editor"] = editor;
export{editor};