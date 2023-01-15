import 'package:flutter/material.dart';
import 'package:final_lecture/song.dart';

class Info extends StatelessWidget {
  Info({required this.song, Key? key}) : super(key: key);

  Song song;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Song Info'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text('Name: ${song.name}',
                style: const TextStyle(
                  fontWeight: FontWeight.bold,
                  fontSize: 30,
                ),
            ),
            Text('Artist: ${song.artist}',
              style: const TextStyle(
                fontWeight: FontWeight.bold,
                fontSize: 30,
              ),
            ),
            SizedBox(height: 10),
            ElevatedButton(
                onPressed: (){
                  Navigator.pop(context);
                },
                child: Text('Back'),
            )
          ],
        ),
      ),
    );
  }
}
