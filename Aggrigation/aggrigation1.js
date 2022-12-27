db.getCollection("user").aggregate(

	// Pipeline
	[
		// Stage 1
		{
			$match: {
				"result.semester":"2"
			}
		},

	]

	// Created with Studio 3T, the IDE for MongoDB - https://studio3t.com/

);
