db.getCollection("user").aggregate(

	// Pipeline
	[
		// Stage 1
		{
			$set: {
			  year: { $year: "$date" },
			  month: {$month: "$date"}
			}
		},

		// Stage 2
		{
			$match: {
			    year:2021
			    
			   
			  }
		},

		// Stage 3
		{
			$group: {
			_id:"$year",
			count:{$sum:1},
			userIds:{
				$push:{
				  "$toString":"$_id"
				}
			}
			}
		},

	]

	// Created with Studio 3T, the IDE for MongoDB - https://studio3t.com/

);
