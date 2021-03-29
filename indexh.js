var express = require('express');
var app = express();


var users = [
	{ id: "001", name: "Nguyen A", subject: "Math", grade: "7" },
	{ id: "002", name: "Nguyen B", subject: "Math", grade: "8" },
	{ id: "003", name: "Nguyen C", subject: "Math", grade: "4" },
	{ id: "004", name: "Nguyen D", subject: "Math", grade: "5" },
	{ id: "005", name: "Nguyen E", subject: "Math", grade: "6" },
	{ id: "006", name: "Nguyen F", subject: "Math", grade: "7" },
	{ id: "007", name: "Nguyen G", subject: "Math", grade: "3" },
	{ id: "008", name: "Nguyen H", subject: "Math", grade: "8" },
	{ id: "009", name: "Nguyen I", subject: "Math", grade: "3" },
	{ id: "010", name: "Nguyen K", subject: "Math", grade: "2" }
];


//xem du lieu
app.get('/', function (req, res) {
	res.json(users);

});

//tim kiem
app.get('/:id', function (req, res) {
	var ufind = users.filter((user) => {
		return user.id == req.params.id;

	})
	res.json(ufind);

});

//them du lieu
//Cach 1, dung query parameters
app.post('/post', function (req, res) {
	var uadd = { id: req.query.id, 
				name: req.query.name, 
				subject: req.query.subject, 
				grade: req.query.grade }
	users.push(uadd);
	console.log(uadd);
	res.json(users);
});
/* app.post('/:id/:name/:subject/:grade', function (req, res) {
	var uadd = { id: req.params.id, name: req.params.name, subject: req.params.subject, grade: req.params.grade }
	users.push(uadd);
	res.json(users);

}); */

//xoa du lieu
app.delete('/:id', function (req, res) {
	var udel = users.filter((user) => {
		return user.id !== req.params.id;

	})
	users = udel;
	res.json(users);
});

//sua du lieu
app.put('/:id/:name/:subject/:grade', function (req, res) {
	for (let index = 0; index < users.length; index++) {
		var x = 0;
		if (req.params.id == users[index].id) {
			x = index;
			users[index].name = req.params.name;
			users[index].subject = req.params.subject;
			users[index].grade = req.params.grade;
			break;

		}

	}
	res.json(users);

});


app.listen(8080);