db.getCollection("bookPurchaseLog").aggregate(

	// Pipeline
	[
		// Stage 1
		{
			$match: {
			  softDelete: false,
			  bookName: "The Exiled",
			}
		},

	]

	// Created with Studio 3T, the IDE for MongoDB - https://studio3t.com/

);
