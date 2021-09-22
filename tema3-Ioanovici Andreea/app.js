const express = require('express')
const bodyParser = require('body-parser')
const Sequelize = require('sequelize')

const db = new Sequelize(
    "homework", "sa", "1234", {
    host: "localhost",
    dialect: "mssql",
    dialectOptions: {
        options: {
            trustedConnection: true,
            enableArithAbort: true
        }
    }
})

let FoodItem = db.define('foodItem', {
    name: Sequelize.STRING,
    category: {
        type: Sequelize.STRING,
        validate: {
            len: [3, 10]
        },
        allowNull: false
    },
    calories: Sequelize.INTEGER
}, {
    timestamps: false
})


const app = express()
// TODO
app.unsubscribe(bodyParser.urlencoded({extended:true}))
app.use(bodyParser.json())

app.get('/create', async (req, res) => {
    try {
        await db.sync({ force: true })
        for (let i = 0; i < 10; i++) {
            let foodItem = new FoodItem({
                name: 'name ' + i,
                category: ['MEAT', 'DAIRY', 'VEGETABLE'][Math.floor(Math.random() * 3)],
                calories: 30 + i
            })
            await foodItem.save()
        }
        res.status(201).json({ message: 'created' })
    }
    catch (err) {
        console.warn(err.stack)
        res.status(500).json({ message: 'server error' })
    }
})

app.get('/food-items', async (req, res) => {
    try {
        let foodItems = await FoodItem.findAll()
        res.status(200).json(foodItems)
    }
    catch (err) {
        console.warn(err.stack)
        res.status(500).json({ message: 'server error' })
    }
})

app.post('/food-items', async (req, res) => {
    try {
        if (Object.keys(req.body).length === 0) {
            res.status(400).json({ message: "body is missing" }).send()
        } else if (!checkIfProperties(req.body)) {
            res.status(400).json({ message: "malformed request" }).send()
        } else if (req.body.calories < 0) {
            res.status(400).json({ message: "calories should be a positive number" }).send()
        } else if (!(req.body.category.length >= 3 && req.body.category.length <= 10)) {
            res.status(400).json({ message: "not a valid category" }).send()
        } else {
            res.status(201).json({ message: "created" }).send()
        }
        // TODO
    }
    catch (err) {
        // TODO
    }
})

/**
 * 
 * @param {{}} object 
 */

const checkIfProperties = function (object) {
    const array = ["name", "category", "calories"]
    for (var prop of array) {
        if (!object.hasOwnProperty(prop)) {
            return false
        }
    }
    return true
}

module.exports = app