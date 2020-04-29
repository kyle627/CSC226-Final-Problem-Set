//Kyle Evangelisto
//Professor aw
//CSC 226
//4-28-2020 1pm- 230pm || Updated to let user choose target word 4/29/2020 11:35pm
open System

[<EntryPoint>]
let main argv =
    //List is created
    let fruits = ["Apple"; "Banana"; "Cherry"; "Peach"; "Coconut"; "Orange"] //required list!
    //Output for user! 
    printf("List before filtratration (and formatting) for the target word.") 
    printf "\n%A" fruits
    //target word is selected!
    printf "\nPlease enter in the target word you want to filter: "
    let target = Console.ReadLine() //required target!
    printf "\n\nList after the target word is removed (and formatted)\n"

    let rec format items  = //recursive method to format list output, not required!
        match items with //functional style match statement
        | [] -> ()
        | head::tail -> 
        printfn "%s" head //prints out the newly formated list
        format tail //recursively calls itself to print each element!

    //Required "remove when" subroutine with two parameters (list and target)
    let rec removeWhen items target =
        let filteredlist = items |> List.filter (fun x -> x <> target) //logic to filter the target word(s) out of the list, required!
        format filteredlist //function call to format list, not required!
        
    removeWhen fruits target //function call with two parameters, required! 

    exit 0 //Program Ends!

    //user defined target words and lsit elements coming when i get motivated again
    