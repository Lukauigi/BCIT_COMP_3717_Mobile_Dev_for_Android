import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:final_exam/playing_card.dart';

class ItemCardView extends StatelessWidget {

  ItemCardView({
    required this.playingCard,
    required this.more,
    required this.selected,
    Key? key,}): super(key: key);

  PlayingCard playingCard;
  Function() selected;
  Function() more;

  @override
  Widget build(BuildContext context) {
    return Card(
      color: Colors.deepPurple[900],
      child: Column(
      children: [
        SizedBox(
          height: 50,
          //child: Center(
            child: Column(
              children: [
                Text('${playingCard.value} of ${playingCard.suit}',
                textAlign: TextAlign.left,
                style: const TextStyle(
                  fontSize: 30,
                  color: Colors.white,
                ),
                ),
                TextButton(onPressed: more, child: Text('More', style: TextStyle(fontSize: 10))),
              ],
            )
          ),
      ]
      )
      //),
    );
  }


}
