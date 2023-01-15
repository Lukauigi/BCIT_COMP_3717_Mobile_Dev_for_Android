import 'package:flutter/material.dart';
import 'package:final_lecture/song.dart';

class SongCard extends StatelessWidget {

   SongCard({
    required this.song,
    required this.info,
    required this.delete,
    Key? key,}) : super(key: key);

  Song song;
  Function() info;
  Function() delete;

  @override
  Widget build(BuildContext context) {
    return Card(
        color: Colors.brown,
        child: Container(
          height: 150,
          child: Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text('${song.name} by ${song.artist}',
                  style: const TextStyle(fontSize: 20),
                ),
                TextButton(
                    onPressed: info,
                    child: const Text('Song Info', style: TextStyle(fontSize: 20))
                ),
                TextButton(
                    onPressed: delete,
                    child: const Text('Delete',
                        style: TextStyle(
                            fontSize: 20,
                            color: Colors.red
                        )
                    )
                )
              ],
            ),
          ),
        )
    );
  }
}