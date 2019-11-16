package id.pahang.backend4.controller;

import id.pahang.backend4.model.Vote;
import id.pahang.backend4.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vote")
public class VoteController {

    @Autowired
    VoteRepository voteRepository;

    @GetMapping("/getCountByPost/{postId}")
    public int getVoteCount(@PathVariable Long postId){
        return voteRepository.findByPostId(postId).size();
    }

    @GetMapping()
    public List<Vote> getAllVOte(){
        return voteRepository.findAll();
    }

    @PostMapping("/vote")
    public int vote(@RequestBody Vote vote){
        if(voteRepository.findByPostIdAndUserId(vote.getPostId(), vote.getUserId()).size()==0)
            voteRepository.save(vote);
        return voteRepository.findByPostId(vote.getPostId()).size();
    }

    @PostMapping("/unvote")
    public int unvote(@RequestBody Vote vote) {
        if (!(voteRepository.findByPostIdAndUserId(vote.getPostId(), vote.getUserId()).size() == 0)) {
            Vote oldVote = voteRepository.findByPostIdAndUserId(vote.getPostId(), vote.getUserId()).get(0);
            voteRepository.findById(oldVote.getId());
        }
        return voteRepository.findByPostId(vote.getPostId()).size();
    }
}
