from pydantic import BaseModel
from typing import List

class Club(BaseModel):
    id: str
    name: str
    country: str
    confederation: str
    treble_years: List[str]
    competition_ids: List[str]
    logo_url: str
    web_url: str
    description: str