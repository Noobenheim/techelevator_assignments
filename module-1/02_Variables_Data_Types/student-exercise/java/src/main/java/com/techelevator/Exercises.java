package com.techelevator;

public class Exercises {

	public static void main(String[] args) {
		// this is for me, ignore it
		int problemNumber = 1;

        /*
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */

		// ### EXAMPLE:
		int initialNumberOfBirds = 4;
		int birdsThatFlewAway = 1;
		int remainingNumberOfBirds = initialNumberOfBirds - birdsThatFlewAway;
		
		System.out.println((problemNumber++)+". There are "+remainingNumberOfBirds+" birds remaining.");

        /*
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */

		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;
		
		System.out.println((problemNumber++)+". There are "+numberOfExtraBirds+" more birds than nests.");

        /*
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		
		int playingRaccoonCount = 3;
		int leavingRaccoonCount = 2;
		int currentRaccoonCount = playingRaccoonCount - leavingRaccoonCount;
		
		System.out.println((problemNumber++)+". There are "+currentRaccoonCount+" raccoons left in the woods.");

        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		
		int flowerCount = 5;
		int beeCount = 3;
		int unmatchedFlowerCount = flowerCount - beeCount;
		
		System.out.println((problemNumber++)+". There are "+unmatchedFlowerCount+" more flowers than bees.");

        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		
		int pigeonEatingCount = 1;
		int pigeonAdditionCount = 1;
		int currentPigeonEatingCount = pigeonEatingCount + pigeonAdditionCount;
		
		System.out.println((problemNumber++)+". There are "+currentPigeonEatingCount+" pigeons eating breadcrumbs now.");

        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		
		int owlOnFenceCount = 3;
		int owlAdditionCount = 2;
		int currentOwlOnFenceCount = owlOnFenceCount + owlAdditionCount;

		System.out.println((problemNumber++)+". There are "+currentOwlOnFenceCount+" owls now on the fence.");
		
        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		
		int workingBeaverCount = 2;
		int leavingBeaverCount = 1;
		int currentWorkingBeaverCount = workingBeaverCount - leavingBeaverCount;
		
		System.out.println((problemNumber++)+". There are "+currentWorkingBeaverCount+" beavers working on their home.");

        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		
		int toucanOnTreeCount = 2;
		int toucanAdditionCount = 1;
		int currentToucanOnTreeCount = toucanOnTreeCount + toucanAdditionCount;
		
		System.out.println((problemNumber++)+". There are "+currentToucanOnTreeCount+" toucans on the tree limb.");

        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		
		int squirrelOnTreeCount = 4;
		int nutCount = 2;
		int squirrelNutDifference = squirrelOnTreeCount - nutCount;
		
		System.out.println((problemNumber++)+". There are "+squirrelNutDifference+" more squirrels than nuts.");

        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		
		int quarterCount = 1;
		final int quarterCentAmount = 25;
		int dimeCount = 1;
		final int dimeCentAmount = 10;
		int nickelCount = 2;
		final int nickelCentAmount = 5;
		
		double totalMoneyFoundCents = (quarterCount * quarterCentAmount)
									+ (dimeCount * dimeCentAmount)
									+ (nickelCount * nickelCentAmount);
			
		// Format it correctly
		System.out.println((problemNumber++)+". She found $"+String.format("%.2f", totalMoneyFoundCents/100)+".");

        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		
		int mrsBriersClassMuffinCount = 18;
		int mrsMacAdamsClassMuffinCount = 20;
		int mrsFlannerysClassMuffinCount = 17;
		
		int totalMuffinsBaked = mrsBriersClassMuffinCount + mrsMacAdamsClassMuffinCount + mrsFlannerysClassMuffinCount;
		
		System.out.println((problemNumber++)+". First grade baked "+totalMuffinsBaked+" muffins.");

        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		
		double yoyoCost = 0.24;
		double whistleCost = 0.14;
		
		double totalCost = yoyoCost + whistleCost;
		
		System.out.println((problemNumber++)+". The total spent was $"+totalCost+".");

        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */

		int treatCount = 5;
		int largeMarshmallowCountPerTreat = 8;
		int miniMarshmallowCountPerTreat = 10;
		
		int totalMarshmallowsUsed = largeMarshmallowCountPerTreat*treatCount
								  + miniMarshmallowCountPerTreat*treatCount;
		
		System.out.println((problemNumber++)+". Mrs. Hilt used a total of "+totalMarshmallowsUsed+" marshmallows.");
		
        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		
		int mrsHiltsSnowAmount = 29;
		int mrsBrecknockSnowAmount = 17;
		
		int snowDifference = mrsHiltsSnowAmount - mrsBrecknockSnowAmount;
		
		System.out.println((problemNumber++)+". Mrs. Hilt had "+snowDifference+" more inches of snow than Brecknock Elementary School.");

        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
		
		int mrsHiltTotalMoney = 10;
		int toyTruckCost = 3;
		int pencilCaseCost = 2;
		int mrsHiltMoneyLeft = mrsHiltTotalMoney - toyTruckCost - pencilCaseCost;
		
		System.out.println((problemNumber++)+". Mrs. Hilt has $"+mrsHiltMoneyLeft+" left over.");

        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		
		int marbleCount = 16;
		int lostMarbles = 7;
		int currentMarbleCount = marbleCount - lostMarbles;
		
		System.out.println((problemNumber++)+". Josh has "+currentMarbleCount+" marbles now.");

        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		
		int seashellCount = 19;
		int seashellGoal = 25;
		int seashellRequired = seashellGoal - seashellCount;
		
		System.out.println((problemNumber++)+". Megan needs "+seashellRequired+" more seashells.");

        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		
		int totalBalloonCount = 17;
		int redBalloonCount = 8;
		int greenBalloonCount = totalBalloonCount - redBalloonCount;
		
		System.out.println((problemNumber++)+". There are "+greenBalloonCount+" green balloons.");

        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		
		int bookCount = 38;
		int bookPlacementCount = 10;
		int currentBookCount = bookCount + bookPlacementCount;
		
		System.out.println((problemNumber++)+". There are now "+currentBookCount+" books on the shelf.");

        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		
		int beeLegCount = 6;
		int numberOfBees = 8;
		int totalBeeLegCount = beeLegCount * numberOfBees;
		
		System.out.println((problemNumber++)+". "+beeLegCount+" bees have a total of "+totalBeeLegCount+" legs.");

        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		
		int iceCreamConeCentCost = 99;
		int amountOfIceCreamCones = 2;
		int totalIceCreamConeCost = iceCreamConeCentCost * amountOfIceCreamCones;
		
		System.out.println((problemNumber++)+". "+amountOfIceCreamCones+" ice cream cones cost $"+(totalIceCreamConeCost/100.0)+".");

        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		
		int totalRocksNeeded = 125;
		int currentRockCount = 64;
		int neededRockCount = totalRocksNeeded - currentRockCount;
		
		System.out.println((problemNumber++)+". Mrs. Hilt needs "+neededRockCount+" more rocks to complete her garden.");

        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		
		int mrsHiltMarbleCount = 38;
		int lostMarbleCount = 15;
		int mrsHiltCurrentMarbleCount = mrsHiltMarbleCount - lostMarbleCount;
		
		System.out.println((problemNumber++)+". Mrs. Hilt now has "+mrsHiltCurrentMarbleCount+" marbles.");

        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		
		int concertDistance = 78;
		int drivenDistance = 32;
		int currentDistanceRequired = concertDistance - drivenDistance;
		
		System.out.println((problemNumber++)+". They now have "+currentDistanceRequired+" more miles to drive.");

        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
		
		int saturdayMorningHoursShovelingSnow = 1;
		int saturdayMorningMinutesShovelingSnow = 30;
		int saturdayAfternoonMinutesShovelingSnow = 45;
		
		int totalSaturdayTotalMinutesShovelingSnowAmount = saturdayMorningHoursShovelingSnow * 60
														 + saturdayMorningMinutesShovelingSnow
														 + saturdayAfternoonMinutesShovelingSnow;
		
		int totalSaturdayMinutesShovelingSnowAmount = totalSaturdayTotalMinutesShovelingSnowAmount%60;
		int totalSaturdayHoursShovelingSnowAmount = totalSaturdayTotalMinutesShovelingSnowAmount/60;
		
		System.out.println((problemNumber++)+". Mrs. Hilt spent a total of "+totalSaturdayHoursShovelingSnowAmount+" hours and "+totalSaturdayMinutesShovelingSnowAmount+" minutes shoveling snow.");

		/*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		
		int totalHotDogsPurchased = 6;
		int hotDogCentCost = 50;
		double totalHotDogCentCost = hotDogCentCost * totalHotDogsPurchased;

		// format string
		System.out.println((problemNumber++)+". Mrs. Hilt paid a total of $"+String.format("%.2f", (totalHotDogCentCost/100.0))+" for hot dogs.");
		
        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		
		int mrsHiltMoneyCentTotal = 50;
		int pencilCost = 7;
		int pencilsPurchasable = (mrsHiltMoneyCentTotal / pencilCost);
		
		System.out.println((problemNumber++)+". Mrs. Hilt can buy "+pencilsPurchasable+" pencils.");

        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		
		int sightedButterflyCount = 33;
		int sightedOrangeButterflyCount = 20;
		int sightedRedButterflyCount = sightedButterflyCount - sightedOrangeButterflyCount;
		
		System.out.println((problemNumber++)+". Mrs. Hilt saw "+sightedRedButterflyCount+" red butterflies.");

        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		
		int moneyCentsGivenToClerk = 100;
		int totalCandyCentCost = 54;
		int totalChangeReturned = moneyCentsGivenToClerk - totalCandyCentCost;
		
		System.out.println((problemNumber++)+". Kate should get $"+(totalChangeReturned/100.0)+" back.");

        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		
		int backyardTreeCount = 13;
		int additionalTreeCount = 12;
		int futureTreeCount = backyardTreeCount + additionalTreeCount;
		
		System.out.println((problemNumber++)+". Mark will have "+futureTreeCount+" trees in his backyard.");

        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		
		int daysUntilGrandma = 2;
		final int hoursPerDay = 24;
		int hoursUntilGrandma = hoursPerDay * daysUntilGrandma;
		
		System.out.println((problemNumber++)+". Joy only has "+hoursUntilGrandma+" until she can see her grandma!");

        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		
		int kimCousinCount = 4;
		int cousinGumGiftCount = 5;
		int kimTotalGumCount = kimCousinCount * cousinGumGiftCount;
		
		System.out.println((problemNumber++)+". Kim will need a total of "+kimTotalGumCount+" sticks of gum for her cousins.");

        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		
		int danMoneyCentCount = 300;
		int candyBarCentCost = 100;
		int danMoneyCentLeft = danMoneyCentCount - candyBarCentCost;
		
		// format String
		System.out.println((problemNumber++)+". Dan has $"+String.format("%.2f", danMoneyCentLeft/100.0)+" left.");

        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		
		int boatsInLakeCount = 5;
		int peopleInBoatsInLakeCount = 3;
		int totalPeopleInLakeCount = boatsInLakeCount * peopleInBoatsInLakeCount;
		
		System.out.println((problemNumber++)+". There are a total of "+totalPeopleInLakeCount+" people in the lake.");

        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		
		int ellenLegoCount = 380;
		int ellenLostLegoCount = 57;
		int ellenCurrentLegoCount = ellenLegoCount - ellenLostLegoCount;
		
		System.out.println((problemNumber++)+". Ellen only has "+ellenCurrentLegoCount+" LEGOs left and will never be able to finish her set.");

        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		
		int arthurBakedMuffinCount = 35;
		int arthurMuffinGoalCount = 83;
		int arthurRemainingMuffinCount = arthurMuffinGoalCount - arthurBakedMuffinCount;
		
		System.out.println((problemNumber++)+". Arthur only has "+arthurRemainingMuffinCount+" muffins left to bake before he's done.");

        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		
		int willyCrayonCount = 1400;
		int lucyCrayonCount = 290;
		int willyLucyCrayonDifference = willyCrayonCount - lucyCrayonCount;
		
		System.out.println((problemNumber++)+". Willy has "+willyLucyCrayonDifference+" more crayons than Lucy.");

        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		
		int stickersOnPageCount = 10;
		int pageCount = 22;
		int totalStickers = stickersOnPageCount * pageCount;
		
		System.out.println((problemNumber++)+". After filling up "+pageCount+" pages of stickers, there are a total of "+totalStickers+" in that book.");

        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		
		int totalCupcakesToShare = 96;
		int totalChildrenCount = 8;
		int cupcakesPerChild = totalCupcakesToShare / totalChildrenCount;
		
		System.out.println((problemNumber++)+". Each child will get "+cupcakesPerChild+" cupcakes.");

        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
		int totalGingerbreadCookieCount = 47;
		int gingerbreadCookiesPerJar = 6;
		int extraGingerbreadCookies = totalGingerbreadCookieCount % gingerbreadCookiesPerJar;
		
		System.out.println((problemNumber++)+". There are "+extraGingerbreadCookies+" cookies that she can eat guilt-free.");

        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
		
		int preparedCroissants = 59;
		int numberOfNeighbors = 8;
		int extraCroissants = preparedCroissants % numberOfNeighbors;
		
		System.out.println((problemNumber++)+". She can also eat "+extraCroissants+" croissants without worry.");

        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		
		int oatmealCookiesPerTray = 12;
		int oatmealCookieGoal = 276;
		int oatmealCookieTraysRequired = oatmealCookieGoal / oatmealCookiesPerTray;
		
		System.out.println((problemNumber++)+". Marian will need "+oatmealCookieTraysRequired+" trays for her cookies.");

        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		
		int mariansMadePretzels = 480;
		final int servingSize = 12;
		int mariansServingsCreated = mariansMadePretzels / servingSize;
		
		System.out.println((problemNumber++)+". Marian has created "+mariansServingsCreated+" servings of pretzels.");

        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		
		int lemonCupcakesForOrphanage = 53;
		int lemonCupcakesLeftAtHome = 2;
		int lemonCupcakesPerBox = 3;
		
		int boxesGivenToOrphanage = (lemonCupcakesForOrphanage - lemonCupcakesLeftAtHome)
								  / lemonCupcakesPerBox;
		
		System.out.println((problemNumber++)+". There were "+boxesGivenToOrphanage+" boxes of lemon cupcakes made for the orphanage.");

        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		
		int preparedCarrotStickCount = 74;
		int carrotsPerPerson = 12;
		int carrotsUneaten = preparedCarrotStickCount % carrotsPerPerson;
		
		System.out.println((problemNumber++)+". Susie's mom has "+carrotsUneaten+" carrots left.");

        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		
		int totalTeddyBearCount = 98;
		final int shelfTeddyBearCapacity = 7;
		int shelvesFilled = totalTeddyBearCount / shelfTeddyBearCapacity;
		
		System.out.println((problemNumber++)+". There are "+shelvesFilled+" shelves completely filled.");

        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		
		final int albumMaxPictures = 20;
		int totalPictureCount = 480;
		int numberOfAlbumsRequired = totalPictureCount / albumMaxPictures;
		
		System.out.println((problemNumber++)+". Susie's mother will need "+numberOfAlbumsRequired+" albums for all her photos.");

        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		
		int joesTradingCardCollectionCount = 94;
		final int boxMaxCardCount = 8;
		int unfilledBoxCount = joesTradingCardCollectionCount % boxMaxCardCount;
		
		System.out.println((problemNumber++)+". Joe has "+unfilledBoxCount+" cards in his unfilled box.");

        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		
		int totalBookCount = 210;
		int totalShelfCount = 10;
		int booksPerShelf = totalBookCount / totalShelfCount;
		
		System.out.println((problemNumber++)+". Each shelf in the reading room will need "+booksPerShelf+" books.");

        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		
		int cristinaCroissantCount = 17;
		int numberOfGuests = 7;
		int croissantsPerGuest = cristinaCroissantCount / numberOfGuests;
		
		System.out.println((problemNumber++)+". Each guest will receive "+croissantsPerGuest+" croissants.");

        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in 
        feet by the combined hourly rate of the painters.
        
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */
		
		double billRoomTimeInHours = 2.15;
		double jillRoomTimeInHours = 1.90;
		
		double billRoomTimePerHour = 1 / billRoomTimeInHours;
		double jillRoomTimePerHour = 1 / jillRoomTimeInHours;
		
		double combinedRate = billRoomTimePerHour + jillRoomTimePerHour;
		
		// 5 Rooms
		int numberOfRooms = 5;
		double hoursToFinishRooms = numberOfRooms / combinedRate;
		
		System.out.println("Challenge 1 Part 1: Together, to paint "+numberOfRooms+" rooms, it'll take "+hoursToFinishRooms+" hours."); 
		
		
		// 623 rooms, 8 hours per day
		numberOfRooms = 623;
		hoursToFinishRooms = numberOfRooms / combinedRate;
		int workingHoursPerDay = 8;
		double numberOfDays = hoursToFinishRooms / workingHoursPerDay;

		System.out.println("Challenge 1 Part 2: Together, to paint "+numberOfRooms+" rooms, it'll take "+hoursToFinishRooms+" hours which is "+numberOfDays+" days."); 
		

        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */

		String firstName = "Dan";
		String lastName = "Podobnik";
		char middleInitial = 'X'; // I don't have a middle name!
		
		String format = "%3$s, %1$s %2$c.";
		
		String formattedName = String.format(format, firstName, middleInitial, lastName);

		System.out.println("Challenge 2: "+formattedName); 

        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */
		
		int distanceNYtoChicago = 800;
		int trainAlreadyTravelDistance = 537;
		double percentTraveled = (double)trainAlreadyTravelDistance / distanceNYtoChicago;
		
		System.out.println("Challenge 3: "+(int)(percentTraveled * 100)+"% of the trip is complete.");
	}

}
