import 'package:final_exam/playing_card.dart';
import 'package:flutter/material.dart';


class SelectedCardView extends StatelessWidget {

  SelectedCardView({
    required this.playingCard,
    Key? key,}): super(key: key);

  PlayingCard playingCard;

  @override
  Widget build(BuildContext context) {
    return Card(
      color: Colors.indigo,
      child: Container(

      ),
    );
  }


}