const express = require("xpress")
const app = express()
const PORT = 5000

app.get("/", (req, res) => {
    res.send("welcome to jenkins--sds")
})

app.listen(PORT, () => {
    console.log("app is running on this ", PORT)
})
