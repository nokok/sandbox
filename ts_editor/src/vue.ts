import Vue from "vue";
import {editor} from "./codemirror";
import {consoleArea} from "./dom";

const vm = new Vue({
    el: "#toolbar",
    methods: {
        "onSaveButtonClicked" : function() {
            editor.save();
        },
        "onExecButtonClicked" : function() {
            var result = eval(editor.getValue());
            consoleArea.innerText = result;
        },
        "onRestoreButtonClicked" : function () {
            editor.setValue(localStorage.getItem("SaveData") || "");
        }
    }
});
window["vm"] = vm;

export{vm};