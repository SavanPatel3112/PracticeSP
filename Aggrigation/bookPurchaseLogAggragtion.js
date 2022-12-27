db.getCollection("bookPurchaseLog").aggregate(

	// Pipeline
	[
		// Stage 1
		{
			$set: { year: { $year: "$date" }, month: { $month: "$date" } }
		},

		// Stage 2
		{
			$match: { year: 2021,month:09 }
		},

		// Stage 3
		{
			$group: {
			    _id: {"month":"$month","bookName":"$bookName"},
			  month: { $first: "$month" },
			  count: { $sum: 1 },
			  userIds: { $push: { $toString: "$_id" } },
			},
		},

		// Stage 4
		{
			$group: {
			  _id:"$_id.bookName",
			  
			  bookData:{$push:{"month":"$month","userIds":"$userIds","count":"$count"}}
			}
		},

		// Stage 5
		{
			$unwind: {
			    path : "$bookData",
			}
		},

		// Stage 6
		{
			$group: {
			  _id:"$bookData.month",
			  bookData:{$push:{"bookName":"$_id","count":"$bookData.count"}},
			  totalCount:{$sum:"$bookData.count"}
			  
			}
		},

	]

	// Created with Studio 3T, the IDE for MongoDB - https://studio3t.com/

);
