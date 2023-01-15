import 'package:flutter/material.dart';
import 'package:lukaszbednarek_lab8/character.dart';

void main() {
  runApp(
      MaterialApp(
        home: Home(),
      )
  );
}

class Home extends StatelessWidget {
  Home({Key? key}) : super(key: key);

  final List<Character> theLegendOfZelda = [
    Character(name: "Link"),
    Character(name: "Princess Zelda"),
    Character(name: "Goron"),
    Character(name: "Ganon"),
    Character(name: "Epona")
  ];

  final List<Character> spongeBobSquarePants = [
    Character(name: "spongeBob"),
    Character(name: "squidward"),
    Character(name: "patrick"),
    Character(name: "plankton"),
    Character(name: "Mr. Krabs")
  ];

  final List<Character> theMandalorian = [
    Character(name: "Mando"),
    Character(name: "Moff Gideon"),
    Character(name: "Cara Dune"),
    Character(name: "Grogu"),
    Character(name: "Boba Fett")
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Pop Culture Characters"),
        centerTitle: true,
      ),
      body: IntrinsicHeight(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[

            //zelda header
            Container(
              margin: const EdgeInsets.fromLTRB(0, 8, 0, 5),

              child: const Text(
                "The Legend of Zelda",
                style: TextStyle(
                  fontWeight: FontWeight.bold,
                  fontSize: 23
                ),
              ),
            ),

            //zelda card
            ConstrainedBox(
              constraints: const BoxConstraints(
                  minHeight: 170,
                  maxHeight: 170
              ),
              child: Card(
              margin: const EdgeInsets.all(3.0),
              elevation: 6,
              color: Colors.orange,
              child: ListView(
                scrollDirection: Axis.horizontal,
                children: theLegendOfZelda.map((e) => cardTemplate(e, Colors.orange[800]!)).toList(),
                        ),
                    ),
              ),

            //spongebob header
            Container(
              margin: const EdgeInsets.fromLTRB(0, 8, 0, 5),
              child: const Text(
                "SpongBob SquarePants",
                style: TextStyle(
                    fontWeight: FontWeight.bold,
                    fontSize: 23
                ),
              ),
            ),

            //spongebob card
            ConstrainedBox(
              constraints: const BoxConstraints(
                  minHeight: 170,
                  maxHeight: 170
              ),
              child: Card(
                elevation: 6,
                color: Colors.pink,
                margin: const EdgeInsets.all(3.0),
                child: ListView(
                  scrollDirection: Axis.horizontal,
                  children: spongeBobSquarePants.map((e) => cardTemplate(e, Colors.pink[800]!)).toList(),
                            ),
                      ),
                ),

            //mando header
            Container(
              margin: const EdgeInsets.fromLTRB(0, 8, 0, 5),
              child: const Text(
                "The Mandalorian",
                style: TextStyle(
                    fontWeight: FontWeight.bold,
                    fontSize: 23
                ),
              ),
            ),

            //mando card
            ConstrainedBox(
              constraints: const BoxConstraints(
                  minHeight: 170,
                  maxHeight: 170
              ),
              child: Card(
                elevation: 6,
                color: Colors.green,
                margin: const EdgeInsets.all(3.0),
                  child: ListView(
                    scrollDirection: Axis.horizontal,
                    children: theMandalorian.map((e) => cardTemplate(e, Colors.green[800]!)).toList(),
                  ),
                ),
                )

        ],
        ),
      ),
    );
  }

  Widget cardTemplate(Character character, Color textColor) {
    return UnconstrainedBox(
        alignment: Alignment.center,
        child: Padding(
          padding: const EdgeInsets.all(20.0),
          child: Card(
            elevation: 15,
            color: Colors.green[100],
            child: Container(
              padding: const EdgeInsets.fromLTRB(22, 16, 22, 16),
              child: Center(
                  child: Text(
                      character.name,
                  style: TextStyle(
                    fontSize: 18,
                    fontWeight: FontWeight.bold,
                    color: textColor
                  ),)
              ),
            ),
          ),
        ),
      );
  }

}


