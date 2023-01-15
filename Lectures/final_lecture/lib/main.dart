import 'package:flutter/material.dart';
import 'package:final_lecture/song.dart';
import 'package:final_lecture/song_card.dart';

import 'info_screen.dart';

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
  List<Song> songs = [
    Song(name: 'Imagine', artist: 'John Lennon'),
    Song(name: 'The Final Countdown', artist: 'Europe'),
    Song(name: 'Girls just wanna have fun', artist: 'Carly Ray'),
    Song(name: 'Cherry Pie', artist: 'Warrant'),
    Song(name: 'Baby', artist: 'Justin Beiber'),
  ];

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(
        title: Text('Lecture 12')
      ),
      body: Center(
        child: ListView(
          children: songs.map((e) => SongCard(
              song: e,
              info: (){
                Navigator.push(
                    context,
                    MaterialPageRoute(
                        builder: (context) => Info(song: e,)
                    )
                );
              },
              delete: (){
                setState(() {
                  songs.remove(e);
                });
              })
          ).toList(),
        ),
      )
    );
  }
}


