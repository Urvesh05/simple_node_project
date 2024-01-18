const express = require("xpress")
const app = express()
const PORT = 5000

app.get("/", (req, res) => {
    res.send("welcome to jenkins-!!!00")
})

app.listen(PORT, () => {
    console.log("app is running on this ", PORT)
})
