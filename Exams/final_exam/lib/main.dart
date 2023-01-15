import 'package:final_exam/item_card_view.dart';
import 'package:final_exam/more_screen.dart';
import 'package:flutter/material.dart';
import 'package:final_exam/playing_card.dart';

void main() {
  runApp(MaterialApp(
    home: Home(),
  ));
}

class Home extends StatefulWidget {
  Home({Key? key}) : super(key: key);

  @override
  State<Home> createState() => _HomeState();
}

class _HomeState extends State<Home> {
  List<PlayingCard> cards = [
    PlayingCard(id: '5H', value: '5', suit: 'HEARTS'),
    PlayingCard(id: 'AC', value: 'ACE', suit: 'CLUBS'),
    PlayingCard(id: 'JC', value: 'JACK', suit: 'CLUBS'),
    PlayingCard(id: '2D', value: '2', suit: 'DIAMONDS'),
    PlayingCard(id: '3H', value: '3', suit: 'HEARTS'),
    PlayingCard(id: '4H', value: '4', suit: 'HEARTS'),
    PlayingCard(id: '5C', value: '5', suit: 'CLUBS'),
    PlayingCard(id: 'QS', value: 'QUEEN', suit: 'SPADES'),
    PlayingCard(id: '3S', value: '3', suit: 'SPADES')
  ];


  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
            title: const Text('Lukasz Bednarek: Fun With Cards')
        ),
        body: Column(
          children: [
            Expanded(child: ListView(
              children: cards.map((e) => ItemCardView(
                playingCard: e,
                more: (){
                  Navigator.push(context,
                      MaterialPageRoute(
                          builder: (context) => MoreScreen(playingCard: e)));
                },
                selected: (){
                  setState(() {

                  });
                },
              ),
              ).toList(),
            ),),
            ElevatedButton(onPressed: () {
              print('selected');
            }, child: Text('Draw Card'))
          ]
    )
    );
  }

}