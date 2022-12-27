db.getCollection("bookPurchaseLog").aggregate(

	// Pipeline
	[
		// Stage 1
		{
			$match: { softDelete: false }
		},

		// Stage 2
		{
			$lookup: {
			  pipeline: [
			    { $match: { $and: [{ $expr: { $eq: ["$_id", "$$userId"] } }] } },
			  ],
			  as: "student",
			  from: "users",
			  let: { userId: { $toObjectId: "$userId" } },
			},
		},

		// Stage 3
		{
			$unwind: { path: "$student" }
		},

		// Stage 4
		{
			$set: { fulName: "$student.fullName" }
		},

		// Stage 5
		{
			$unset: "student"
		},

		// Stage 6
		{
			$group: {
			  userBookDetails: {
			    $push:{"date": { $dateToString: { format: "%m/%d/%Y", date: "$date",timezone:"America/Chicago" } },
			         price: "$price" ,
			  }
			  },
			  count: { $sum: 1 },
			  price:{$sum:"$price"},
			  _id: { fullName: "$fulName", bookName: "$bookName" },
			
			}
		},

		// Stage 7
		{
			$group: {
			  userBookData: {
			    $push: {
			      date: {"$last":"$userBookDetails.date"},
			      price: { $sum: "$userBookDetails.price" },
			      count: { $sum: "$count" },
			      bookName: "$_id.bookName",
			    },
			  },
			  _id: "$_id.fullName",
			  "fullName":{"$first":"$_id.fullName"}
			},
		},

	]

	// Created with Studio 3T, the IDE for MongoDB - https://studio3t.com/

);
