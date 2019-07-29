function updateFunctionAccessory(accessoryId) {
    var x = document.getElementById("accessoryName" + accessoryId);
    var b = document.getElementById("accessoryNameSave" + accessoryId);
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }

    if (b.style.display === "none") {
        b.style.display = "block";
    } else {
        b.style.display = "none";
    }
}

function updateFunctionBicycle(bicycleId) {
    var a = document.getElementById("bicycleName" + bicycleId);
    var b = document.getElementById("bicycleNameSave" + bicycleId);
    var c = document.getElementById("bicycleWeight" + bicycleId);
    var d = document.getElementById("bicycleDistance" + bicycleId);

    if (a.style.display === "none") {
        a.style.display = "block";
    } else {
        a.style.display = "none";
    }

    if (b.style.display === "none") {
        b.style.display = "block";
    } else {
        b.style.display = "none";
    }

    if (c.style.display === "none") {
        c.style.display = "block";
    } else {
        c.style.display = "none";
    }

    if (d.style.display === "none") {
        d.style.display = "block";
    } else {
        d.style.display = "none";
    }
}